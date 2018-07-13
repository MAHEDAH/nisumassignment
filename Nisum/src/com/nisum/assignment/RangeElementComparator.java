package com.nisum.assignment;

import java.util.Comparator;

/**
 * This is Comparator class used for sorting RangeElement objects by lowerBound value
 * @author Admin
 *
 */
public class RangeElementComparator  implements Comparator<RangeElement> {

	@Override
	public int compare(RangeElement o1, RangeElement o2) {
		return o1.getLowerBound() - o2.getLowerBound();
	}
	

}
