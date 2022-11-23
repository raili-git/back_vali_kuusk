package ee.valiit.back_vali_kuusk.domain.product.height;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface HeightMapper {


    @Mapping(source = "id", target = "heightId")
    @Mapping(source = "gap", target = "heightGap")

    HeightDto heightToHeightDto(Height height);

    List<HeightDto> heightsToHeightDtos (List<Height>heights);


}
