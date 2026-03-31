package core.beans;

import java.io.Serializable;
import java.util.List;

public class JSONServer implements Serializable {
    int total;
    List<Object[]> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Object[]> getList() {
        return list;
    }

    public void setList(List<Object[]> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "JSONServer{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}
