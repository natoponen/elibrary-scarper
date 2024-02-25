package ru.rudn.ntoponen.elibraryscarper.app.api;

public interface GetPageOutbound {
    /**
     * Получить страницу по url
     *
     * @param url URL страницы, которую получаем
     */
    public void getPageOutbound(String url);
}
