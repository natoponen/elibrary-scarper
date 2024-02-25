package ru.rudn.ntoponen.elibraryscarper.app.api;

public interface GetPageTitleInbound {
    /**
     * Получить заголовок страницы по url
     *
     * @param url URL страницы, заголовок которой получаем
     */
    public String execute(String url);
}
