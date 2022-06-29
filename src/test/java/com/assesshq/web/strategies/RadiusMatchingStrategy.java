package com.assesshq.web.strategies;

import com.assesshq.web.model.Planet;

import java.text.ParseException;

public class RadiusMatchingStrategy implements MatchingStrategy {

    private final double radius;
    public RadiusMatchingStrategy(double radius) {
        this.radius = radius;
    }
    @Override
    public boolean match(Planet planet) throws ParseException {
        return planet.getRadius() == radius;
    }
}
