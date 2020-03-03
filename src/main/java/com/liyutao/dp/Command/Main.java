package com.liyutao.dp.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther lytstart
 * @create 2020-02-28-21:16
 * 菜单命令
 */
public class Main {
    public static void main(String[] args) {
        Content c = new Content();

        Command insertCommand = new InsertCommand(c);
        insertCommand.doit();
        insertCommand.undo();

        Command copyCommand = new CopyCommand(c);
        copyCommand.doit();
        copyCommand.undo();

        Command deleteCommand = new DeleteCommand(c);
        deleteCommand.doit();
        deleteCommand.undo();

        List<Command> commands = new ArrayList<>();
        commands.add(new InsertCommand(c));
        commands.add(new CopyCommand(c));
        commands.add(new DeleteCommand(c));

        for (Command comm : commands) {
            comm.doit();
        }

        System.out.println(c.msg);

        //倒序来相当于撤销 Ctrl + Z
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }

        System.out.println(c.msg);
    }
}
