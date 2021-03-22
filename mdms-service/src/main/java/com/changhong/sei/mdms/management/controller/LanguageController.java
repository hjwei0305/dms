package com.changhong.sei.mdms.management.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.mdms.management.api.LanguageApi;
import com.changhong.sei.mdms.management.dto.LanguageDto;
import com.changhong.sei.mdms.management.entity.Language;
import com.changhong.sei.mdms.management.service.LanguageService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现功能: 语言类型API服务实现
 *
 * @author 王锦光 wangjg
 * @version 2020-03-22 8:04
 */
@RestController
@Api(value = "LanguageApi", tags = "语言类型API服务")
@RequestMapping(path = "language", produces = MediaType.APPLICATION_JSON_VALUE)
public class LanguageController extends BaseEntityController<Language, LanguageDto> implements LanguageApi {
    private final LanguageService service;

    public LanguageController(LanguageService service) {
        this.service = service;
    }

    @Override
    public BaseEntityService<Language> getService() {
        return service;
    }

    /**
     * 获取所有业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<LanguageDto>> findAll() {
        return ResultData.success(convertToDtos(service.findAll()));
    }

    /**
     * 获取所有未冻结的业务实体
     *
     * @return 业务实体清单
     */
    @Override
    public ResultData<List<LanguageDto>> findAllUnfrozen() {
        return ResultData.success(convertToDtos(service.findAllUnfrozen()));
    }

    /**
     * 获取外国语类型
     *
     * @return 语言类型清单
     */
    @Override
    public ResultData<List<LanguageDto>> getForeignLanguages() {
        List<Language> languages = service.findAll();
        List<Language> foreigns = languages.stream().filter(l-> !StringUtils.equals(LanguageDto.DEFAULT_LANG, l.getCode())).collect(Collectors.toList());
        return ResultData.success(convertToDtos(foreigns));
    }
}
