package org.devemu.entity.manager;

import org.devemu.entity.Alignement;
import org.devemu.program.Main;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

public class AlignementManager {
	public static int getNextId() {
		Session loc1 = Main.getSqlSession();
		Object loc3 = loc1.createCriteria(Alignement.class).setProjection(Projections.max("id")).uniqueResult();
		int loc2 = 0;
		if(loc3 != null)
			loc2 = (int) loc3;
		loc1.close();
		return (loc2 + 1);
	}
}
