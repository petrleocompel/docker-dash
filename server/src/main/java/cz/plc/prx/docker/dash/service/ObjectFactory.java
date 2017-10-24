package cz.plc.prx.docker.dash.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectFactory {
    @Autowired
    @Qualifier("dockerJavaMapper")
    private MapperFactory mapperFactory;


    /**
     * General convert method, it will convert VO to RO without any other logic
     *
     * @param vo    converted object
     * @param clazz class of converted object
     * @param <I>   Generic class of input
     * @param <O>   Generic class of output
     * @return converted object
     */
    public <I, O> O list(final I vo, Class<O> clazz) {
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(vo, clazz);
    }


    /**
     * eneral convert method, it will convert list VO to list RO without any other logic
     *
     * @param vos   list of converted object
     * @param clazz class of converted object
     * @param <I>   Generic class of input
     * @param <O>   Generic class of output
     * @return converted object
     */
    public <I, O> List<O> convert(final Iterable<I> vos, Class<O> clazz) {
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.mapAsList(vos, clazz);
    }
}
