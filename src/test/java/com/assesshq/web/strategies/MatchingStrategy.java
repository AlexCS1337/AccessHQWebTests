package com.assesshq.web.strategies;

import com.assesshq.web.model.Planet;

public interface MatchingStrategy {

    boolean match(Planet planet);
}
