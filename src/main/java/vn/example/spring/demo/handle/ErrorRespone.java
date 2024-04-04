package vn.example.spring.demo.handle;


public class ErrorRespone {
    private String msg;
    private int status;
    private Long timestamp;

    public ErrorRespone(String msg, int status) {
        this.msg = msg;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
