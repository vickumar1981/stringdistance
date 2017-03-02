package org.stringdistance

import org.stringdistance.algo.{LevenshteinDistance, JaroDistance}

object StringDistance extends JaroDistance with LevenshteinDistance
