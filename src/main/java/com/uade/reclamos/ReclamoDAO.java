package com.uade.reclamos;

import com.uade.reclamos.exceptions.ReclamoException;
import com.uade.reclamos.model.Reclamo;
import com.uade.reclamos.model.ReclamoEntity;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ReclamoDAO {

    public List<Reclamo> getAll() throws ReclamoException {
        List<Reclamo> resultado = new ArrayList();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.getCurrentSession();
        s.beginTransaction();
        List<ReclamoEntity> reclamos = s.createQuery("from ReclamoEntity").list();
        Iterator var5 = reclamos.iterator();

        while(var5.hasNext()) {
            ReclamoEntity e = (ReclamoEntity)var5.next();
            resultado.add(this.toNegocio(e));
        }

        s.getTransaction().commit();
        return resultado;
    }

    Reclamo toNegocio(ReclamoEntity e) throws ReclamoException {
        if (e != null) {
            Reclamo reclamo = new Reclamo(e.getId());
            return reclamo;
        } else {
            throw new ReclamoException("No se pudieron recuperar los reclamos");
        }
    }

}
