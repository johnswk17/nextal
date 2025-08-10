package com.blanink.nextal.utils;

/**
 * @Auther: Administrator
 * @Date:2022/7/6 16:07
 * @Version: 1.0
 */
public class Constants {
    public static final String USER_TOKEN_PREFIX = "userToken:";
    public static final String IMAGE_TOKEN_PREFIX = "imageCache:";
    public static final String FILE_PRE = "http://192.168.9.151:8888/";
    public static final String DEFAULT_USER = "default_user.jpg";
    public static final String DEFAULT_NORMAL = "default_normal.jpg";
    public static final String DEFAULT_CAROUSEL = "default_carousel.jpg";
    public static final String DEFAULT_POSTER = "default_poster.png";
    public static final Integer DEFAULT_PAGE_NO = 2;
    public static final Integer DEFAULT_PAGE_SIZE = 10;

    public Constants() {
    }

    public static class PayMethod {
        public static final int WEIXIN = 1;
        public static final int ZHIFUBAO = 2;

        public PayMethod() {
        }
    }

    public static class TOPIC {
        public static final String ORDER_CONSUMER = "order_consumer";
        public static final String ORDER_PROVIDER = "order_provider";
        public static final String ITEM_CONSUMER = "item_consumer";
        public static final String ITEM_PROVIDER = "item_provider";
        public static final String BASE_CONSUMER = "base_consumer";
        public static final String BASE_PROVIDER = "base_provider";
        public static final String PAY_CONSUMER = "pay_consumer";
        public static final String PAY_PROVIDER = "pay_provider";
        public static final String SCHEDULER_CONSUMER = "scheduler_consumer";
        public static final String SCHEDULER_PROVIDER = "scheduler_provider";
        public static final String USER_CONSUMER = "user_consumer";
        public static final String USER_PROVIDER = "user_provider";
        public static final String GATEWAY_ZUUL = "gateway_zuul";
        public static final String ITEM_SEARCH = "item_search";

        public TOPIC() {
        }
    }

    public static class StockStatus {
        public static final Integer lock = 0;
        public static final Integer success = 1;
        public static final Integer cancel = 2;

        public StockStatus() {
        }
    }

    public static class WxpayStatus {
        public static final String DDZTYC = "4001";
        public static final String DDZFYC = "4002";
        public static final String DDYXYC = "4003";

        public WxpayStatus() {
        }
    }

    public static class QgStatus {
        public static final String fail = "-1";
        public static final String getGoods = "1";
        public static final String getOrder = "2";
        public static final String paySuccess = "3";

        public QgStatus() {
        }
    }

    public static class RabbitQueueName {
        public static final String TO_QG_QUEUE = "toQgQueue";
        public static final String TO_CREATE_ORDER = "toCreateOrder";
        public static final String TO_UPDATED_ORDER_QUEUE = "toUpdateOrderQueue";
        public static final String TO_UPDATED_GOODS_QUQUE = "toUpdateGoodsQueue";
        public static final String TO_RESET_SEAT_QUQUE = "toResetSeatQueue";
        public static final String TO_DEL_ORDER_QUQUE = "toDelOrderQueue";
        public static final String TO_RESET_LINKUSER_QUQUE = "toResetLinkUserQueue";
        public static final String TOPIC_EXCHANGE = "topicExchange";

        public RabbitQueueName() {
        }
    }

    public static class QueueName {
        public static final String TO_QG_QUEUE = "toQgQueue";
        public static final String TO_CREATE_ORDER = "toCreateOrder";
        public static final String TO_UPDATED_ORDER_QUEUE = "toUpdateOrderQueue";
        public static final String TO_UPDATED_GOODS_QUQUE = "toUpdateGoodsQueue";

        public QueueName() {
        }
    }

    public static class SchedulerSeatStatus {
        public static final Integer SchedulerSeat_FREE = 1;
        public static final Integer SchedulerSeat_TOPAY = 2;
        public static final Integer SchedulerSeat_PAYSUCCESS = 3;

        public SchedulerSeatStatus() {
        }
    }

    public static class OrderStatus {
        public static final Integer TOPAY = 0;
        public static final Integer SUCCESS = 2;
        public static final Integer FAIL = -1;
        public static final Integer ISNEEDINSURANCE_NO = 0;
        public static final Integer ISNEEDINSURANCE_YES = 1;
        public static final Double NEEDINSURANCE_MONEY = 20.0;

        public OrderStatus() {
        }
    }

    public static class Redis_Expire {
        public static final long DEFAULT_EXPIRE = 60L;
        public static final int SESSION_TIMEOUT = 288000;
        public static final int REPLACEABLE_TIME_RANGE = 1920;
        public static final int REPLACEMENT_PROTECTION_TIMEOUT = 5280;
        public static final int REPLACEMENT_DELAY = 120;

        public Redis_Expire() {
        }
    }

    public static class Image {
        public Image() {
        }

        public static class ImageCategory {
            public static Integer user = 0;
            public static Integer item = 1;

            public ImageCategory() {
            }
        }

        public static class ImageType {
            public static Integer normal = 0;
            public static Integer carousel = 1;
            public static Integer poster = 2;

            public ImageType() {
            }
        }
    }

    public static class ErrorCode {
        public ErrorCode() {
        }

        public static class CommonCode {
            public static String SUCCESS = "0000";
            public static String USER_NO_LOGIN = "0001";
            public static String EXCEPTION = "0002";

            public CommonCode() {
            }
        }
    }
}
