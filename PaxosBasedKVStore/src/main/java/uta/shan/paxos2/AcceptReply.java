package uta.shan.paxos2;

/**
 * Created by xz on 6/2/17.
 */
public class AcceptReply<T> {
    private int pNumber;
    private T value;
    private String status;

    public AcceptReply() {
    }

    public AcceptReply(int pNumber, T value) {
        this.pNumber = pNumber;
        this.value = value;
    }

    //set status
    public void setStatus(String status) {
        this.status = status;
    }

    //get status
    public String getStatus() {
        return this.status;
    }

    //get pnumber
    public int getNum() {
        return this.pNumber;
    }

    //get value
    public T getValue() {
        return this.value;
    }

}
