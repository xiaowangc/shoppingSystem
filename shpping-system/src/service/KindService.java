package service;

import dao.KindDao;
import domain.Kind;
import orm.SqlSession;

import java.util.List;

public class KindService {

    private KindDao kindDao = (KindDao)new SqlSession().getMapping(KindDao.class);

    public List<Kind> selectAllKind(){
        return kindDao.selectAll();
    }

}
