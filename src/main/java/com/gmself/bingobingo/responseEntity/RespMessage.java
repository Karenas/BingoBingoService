package com.gmself.bingobingo.responseEntity;

import com.gmself.bingobingo.BingoException;

public class RespMessage <T extends Resp_result>{

    private Resp_status status;
    private T result;

    private boolean valid;

    public RespMessage() {
        status = new Resp_status();
        valid = false;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setProcessResult(boolean isSuccess){
        String statusRR = "N";
        if (isSuccess){
            statusRR = "Y";
            status.setRW(Resp_processWrongType.NULL.getValue());
            valid = true;
        }
        status.setRR(statusRR);
    }

    public void setProcessWrong(Resp_processWrongType type){
        if (status.getRR().equals("Y")){
            try {
                throw new BingoException("BingoBingoService  --  Resp RR is Y , needn't set RW \n setProcessWrong be jumped");
            } catch (BingoException e) {
                e.printStackTrace();
            }
            return;
        }
        String wrongCode = type.getValue();
        status.setRW(wrongCode);
        valid = true;
    }

    public boolean checkValid(){
        return valid;
    }

    public Resp_status getStatus() {
        return status;
    }

    public void setStatus(Resp_status status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }
}
