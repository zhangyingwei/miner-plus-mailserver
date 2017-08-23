package com.zhangyingwei.miner.mainserver.common.exception;

/**
 * Created by zhangyw on 2017/8/23.
 */
public class MinerMailServerException extends Exception {
    public MinerMailServerException() {
    }

    public MinerMailServerException(String message) {
        super(message);
    }

    public MinerMailServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public MinerMailServerException(Throwable cause) {
        super(cause);
    }

    public MinerMailServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
