package ru.job4j.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ReconstructPhrase {

    private final Queue<Character> descendingElements;

    private final Queue<Character> evenElements;

    public ReconstructPhrase(Queue<Character> descendingElements, Queue<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder stringBuilder = new StringBuilder();
        char temp;
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            temp = evenElements.poll();
            if (i % 2 == 0) {
                stringBuilder.append(temp);
            }
        }
        return String.valueOf(stringBuilder);
    }

    private String getDescendingElements() {
        Deque<Character> deque = new ArrayDeque<>(descendingElements);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < descendingElements.size(); i++) {
            stringBuilder.append(deque.pollLast());
        }
        return String.valueOf(stringBuilder);
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}