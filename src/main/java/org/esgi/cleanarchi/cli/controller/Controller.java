package org.esgi.cleanarchi.cli.controller;

public interface Controller<T> {
    T handle(String[] args);
}
