package com.liyutao.dp.visitor;


/**
 * @auther lytstart
 * @create 2020-02-27-20:25
 *
 * 模拟场景：顾客买电脑
 *    不同的人选购主机的部件，不同的人给不同的价格。
 */
public class Computer {
    ComputerPart cpu = new CPU();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    private void accept(Visitor v) {
        this.cpu.accept(v);
        this.memory.accept(v);
        this.board.accept(v);
    }

    public static void main(String[] args) {
        PersonelVisitor p = new PersonelVisitor();
        new Computer().accept(p);
        System.out.println(p.totalPrice);
    }
}

abstract class ComputerPart {
    abstract void accept(Visitor v);
    //some other operations eg:getName getBrand
    abstract double getPrice();
}

class CPU extends ComputerPart {

    @Override
    public void accept(Visitor v) {
        v.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}

class Memory extends ComputerPart {

    @Override
    public void accept(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}

class Board extends ComputerPart {

    @Override
    public void accept(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 200;
    }
}

interface Visitor {
    void visitMemory(Memory Memory);
    void visitCpu(CPU cpu);
    void visitBoard(Board board);
}

class PersonelVisitor implements Visitor{

    double totalPrice = 0.0;

    @Override
    public void visitMemory(Memory Memory) {
        totalPrice += Memory.getPrice() * 0.85;
    }

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.9;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice() * 0.95;
    }
}

class CropVisitor implements Visitor{

    double totalPrice = 0.0;

    @Override
    public void visitMemory(Memory Memory) {
        totalPrice += Memory.getPrice() * 0.6;
    }

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.75;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice() * 0.75;
    }
}
