package com.pt.recommend.consumer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.pt.recommend.entity.FangAn;
import com.pt.recommend.entity.ZhuSu;
import com.pt.recommend.message.MessageModel;
import com.pt.recommend.message.MessageTag;
import com.pt.recommend.service.BaseService;
import com.pt.recommend.service.ZhengZhuangService;
import com.pt.recommend.service.ZhuSuService;

/**
 * @ClassName: RecommendConsumer
 * @Description: 推荐方案消费者，由单纯的单例模式改为建造者单例模式，在外部控制参数
 * @author 谯雕
 * @date 2018年11月12日
 *
 */
public class RecommendConsumer implements BaseConsumer{

	private static final Logger log = LoggerFactory.getLogger(RecommendConsumer.class);

	private DefaultMQPushConsumer consumer=new DefaultMQPushConsumer();
	private ZhengZhuangService zhengZhuangService=null;
	private ZhuSuService zhuSuService=null;

	private final static RecommendConsumer INSTANCE = new RecommendConsumer();

	private RecommendConsumer() {}
	
	public static final ConsumerBuilder builder=new ConsumerBuilder() {
		
		@Override
		public DefaultMQPushConsumer bindConsumer() {
			// TODO Auto-generated method stub
			return INSTANCE.consumer;
		}
		
		@Override
		@SuppressWarnings("unchecked")
		public <T extends BaseService> BaseConsumer build(T... services) {
			// TODO Auto-generated method stub
			for (BaseService service : services) {
				if (service instanceof ZhengZhuangService) {
					INSTANCE.zhengZhuangService=(ZhengZhuangService) service;
					log.info("症状service:{}",service);
				}
				if (service instanceof ZhuSuService) {
					INSTANCE.zhuSuService=(ZhuSuService) service;
					log.info("主诉service:{}",service);
				}
			}
			return INSTANCE;
		}
	};
	

	@Override
	public void start() {
		try {
			this.consumer.registerMessageListener(new MessageListenerConcurrently() {
				public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
						ConsumeConcurrentlyContext context) {
					for (MessageExt msg : msgs) {
						try {
							MessageModel model = JSON.parseObject(new String(msg.getBody()), MessageModel.class);
							if(model==null) {
								log.warn("消息内容为空");
								return null;
							}
							//新增客户
							if (MessageTag.ZHUSU_CREATE.toString().equals(msg.getTags())) {
								log.info("新增用户");
								JSONObject info = model.getInfo();
								ZhuSu zhuSu = JSON.parseObject(info.getString("zhuSu"),ZhuSu.class);
								FangAn fangAn = JSON.parseObject(info.getString("fangAn"),FangAn.class);
								zhuSuService.saveZhuSu(zhuSu, fangAn);
							}
							//更新老客户
							if (MessageTag.PUTAI_MESSAGE_UPDATE.toString().equals(msg.getTags())) {
								zhengZhuangService.getAllZhengZhuang();
								log.info("更新用户");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
					return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				}
			});

			consumer.start();

		} catch (MQClientException e1) {
			e1.printStackTrace();
		}
	}
}
