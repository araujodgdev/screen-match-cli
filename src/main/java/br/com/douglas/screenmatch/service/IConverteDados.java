package br.com.douglas.screenmatch.service;

public interface IConverteDados {

    <T> T converteDados(String json, Class<T> classe);
}
