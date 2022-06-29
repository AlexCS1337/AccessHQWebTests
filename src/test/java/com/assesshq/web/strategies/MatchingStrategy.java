package com.assesshq.web.strategies;

import com.assesshq.web.model.Planet;

import java.text.ParseException;

public interface MatchingStrategy {

    public boolean match(Planet planet) throws ParseException;
}
