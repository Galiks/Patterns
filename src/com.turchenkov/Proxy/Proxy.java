package com.turchenkov.Proxy;

interface Math{
    int add(int x, int y);
    int sub(int x, int y);
    int mul(int x, int y);
    int div(int x, int y);
}

class Mathematics implements Math {


    @Override
    public int add(int x, int y) {
        return x+y;
    }

    @Override
    public int sub(int x, int y) {
        return x-y;
    }

    @Override
    public int mul(int x, int y) {
        return x*y;
    }

    @Override
    public int div(int x, int y) {
        if (y != 0) {
            return x/y;
        } else {
            return 0;
        }
    }
}

class Proxy implements Math{

    private Mathematics mathematics;

    @Override
    public int add(int x, int y) {
        if(mathematics == null){
            mathematics = new Mathematics();
        }
        return mathematics.add(x,y);
    }

    @Override
    public int sub(int x, int y) {
        if(mathematics == null){
            mathematics = new Mathematics();
        }
        return mathematics.sub(x,y);
    }

    @Override
    public int mul(int x, int y) {
        if(mathematics == null){
            mathematics = new Mathematics();
        }
        return mathematics.mul(x,y);
    }

    @Override
    public int div(int x, int y) {
        if (y != 0) {
            if(mathematics == null){
                mathematics = new Mathematics();
            }
            return mathematics.div(x,y);
        } else {
            return 0;
        }
    }
}

class Program{
    public static void main(String[] args) {
        Math math = new Proxy();
        System.out.println(math.div(5,1));
    }
}
