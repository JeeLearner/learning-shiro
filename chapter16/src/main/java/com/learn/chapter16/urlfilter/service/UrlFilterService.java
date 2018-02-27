package com.learn.chapter16.urlfilter.service;

import com.learn.chapter16.urlfilter.entity.UrlFilter;

import java.util.List;

public interface UrlFilterService {

    public UrlFilter createUrlFilter(UrlFilter urlFilter);
    public UrlFilter updateUrlFilter(UrlFilter urlFilter);
    public void deleteUrlFilter(Long urlFilterId);

    public UrlFilter findOne(Long urlFilterId);
    public List<UrlFilter> findAll();
}