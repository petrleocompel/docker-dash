package cz.plc.prx.docker.dash.configuration;

import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.ContainerConfig;
import cz.plc.prx.docker.dash.model.ContainerConf;
import cz.plc.prx.docker.dash.model.Instance;
import cz.plc.prx.docker.dash.model.InstanceExt;
import cz.plc.prx.docker.dash.model.Mount;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class MapperConfiguration {

    @Bean(name = "dockerJavaMapper")
    public MapperFactory configROMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        initCustom(mapperFactory);

//        mapperFactory.getConverterFactory().registerConverter(new LocalDateConverter());
//        mapperFactory.getConverterFactory().registerConverter(new LocalDatetimeConverter());
        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(LocalDate.class));
        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(LocalDateTime.class));
        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(BigDecimal.class));

        return mapperFactory;
    }


    private void initCustom(final MapperFactory mapperFactory) {
        mapperFactory.classMap(Container.class, Instance.class)
                .byDefault()
                .customize(new CustomMapper<Container, Instance>() {
                    @Override
                    public void mapAtoB(Container container, Instance instance, MappingContext context) {
                        super.mapAtoB(container, instance, context);
                        if (container.getNames() != null && container.getNames().length > 0) {
                            instance.setName(container.getNames()[0]);
                        }
                    }
                })
                .register();

        mapperFactory.classMap(Container.class, InstanceExt.class)
                .byDefault()
                .customize(new CustomMapper<Container, InstanceExt>() {
                    @Override
                    public void mapAtoB(Container container, InstanceExt instanceExt, MappingContext context) {
                        super.mapAtoB(container, instanceExt, context);
                        if (container.getNames() != null && container.getNames().length > 0) {
                            System.out.println(container.getNames());
                            instanceExt.setName(container.getNames()[0]);
                        }
                    }
                })
                .register();
        mapperFactory.classMap(ContainerConfig.class, ContainerConf.class)
                .byDefault()
                .customize(new CustomMapper<ContainerConfig, ContainerConf>() {
                    @Override
                    public void mapAtoB(ContainerConfig conf, ContainerConf configuration, MappingContext context) {
                        super.mapAtoB(conf, configuration, context);
                        if (conf.getCmd() != null) {
                            configuration.setCmd(conf.getCmd());
                        }
                    }
                })
                .register();

        mapperFactory.classMap(InspectContainerResponse.Mount.class, Mount.class)
                .byDefault()
                .customize(new CustomMapper<InspectContainerResponse.Mount, Mount>() {
                    @Override
                    public void mapAtoB(InspectContainerResponse.Mount model, Mount mount, MappingContext context) {
                        super.mapAtoB(model, mount, context);
                        if (model.getName() != null) {
                            mount.setName(model.getName());
                        }
                    }
                })
                .register();
    }

}
