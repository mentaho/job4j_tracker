package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new TerminateAction(out));
        ;
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator()
                + "The program has been terminated." + System.lineSeparator()
        );
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
                actions.add(new ReplaceAction(out));
                actions.add(new TerminateAction(out));

        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                + "0. Edit item" + ln
                + "1. Exit Program" + ln
                + "=== Edit item ===" + ln
                + "Заявка изменена успешно." + ln
                + "Menu:" + ln
                + "0. Edit item" + ln
                + "1. Exit Program" + ln
                + "The program has been terminated." + ln
        );
    }

    @Test
    public void whenFindAllItemsTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
                actions.add(new ShowAllAction(out));
                actions.add(new TerminateAction(out));

        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                + "0. Show all items" + ln
                + "1. Exit Program" + ln
                + "=== Show all items ===" + ln
                + one + ln
                + "Menu:" + ln
                + "0. Show all items" + ln
                + "1. Exit Program" + ln
                + "The program has been terminated." + ln
        );
    }

    @Test
    public void whenFindByNameTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", one.getName(), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
                actions.add(new FindByNameAction(out));
                actions.add(new TerminateAction(out));

        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                + "0. Find item by name" + ln
                + "1. Exit Program" + ln
                + "=== Find items by name ===" + ln
                + one + ln
                + "Menu:" + ln
                + "0. Find item by name" + ln
                + "1. Exit Program" + ln
                + "The program has been terminated." + ln
        );
    }

    @Test
    public void whenFindByIdTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
                actions.add(new FindByIdAction(out));
                actions.add(new TerminateAction(out));

        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                + "0. Find item by id" + ln
                + "1. Exit Program" + ln
                + "=== Find item by id ===" + ln
                + one + ln
                + "Menu:" + ln
                + "0. Find item by id" + ln
                + "1. Exit Program" + ln
                + "The program has been terminated." + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"8", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new TerminateAction(out));

        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                + "0. Exit Program" + ln
                + "Wrong input, you can select: 0 .. 0" + ln
                + "Menu:" + ln
                + "0. Exit Program" + ln
                + "The program has been terminated." + ln
        );
    }
}