package model;

public class NearestPostCode {

    private PostCodeInfo[] result;
    private int status;

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public PostCodeInfo[] getResult()
    {
        return result;
    }

    public void setResult(PostCodeInfo[] result)
    {
        this.result = result;
    }
}
