package ee.valiit.back_vali_kuusk.domain.product.county;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CountyMapper {
    @Mapping(source = "id", target = "countyId")
    @Mapping(source = "name", target = "countyName")

    CountyDto countyToCountyDto(County county);

    List<CountyDto> countiesToCountyDtos (List<County> counties);

}
