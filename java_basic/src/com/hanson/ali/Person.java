package com.hanson.ali;

/**
 * @author 黄忠
 */
public class Person {

    private ThreadLocal<String> name = new ThreadLocal<>();

    public void setName(String name) {
        this.name.set(name);
    }

    public String getName() {
        return this.name.get();
    }

    public void remove() {
        this.name.remove();
    }
}
