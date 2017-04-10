package com;

/**
 * Created by hootting on 2016. 5. 20..
 */
public class Operation implements Comparable<Operation>{
    private static Integer count=0;
    private Integer order;
    private Character operation;

    public Operation() {
        order = count++;
        operation = ' ';
    }

    public Operation(char operation) {
        this.order = count++;
        this.operation = operation;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Character getOperation() {
        return operation;
    }

    public void setOperation(Character operation) {
        this.operation = operation;
    }

    public int compareTo(Operation o) {
        if((this.getOperation()=='*' &&  o.getOperation()=='-') || (this.getOperation()=='*' &&  o.getOperation()=='+'))
            return -1;
        else if(this.getOperation() =='-' && o.getOperation()=='*' || (this.getOperation()=='+' && o.getOperation()=='*'))
            return 1;
        else if(this.getOperation()==o.getOperation())
            return this.getOrder() < o.getOrder() ? 1:-1;
        return this.operation<=o.operation? 1 : -1;
    }
}