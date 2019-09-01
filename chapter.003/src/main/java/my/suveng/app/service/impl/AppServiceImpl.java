package my.suveng.app.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import my.suveng.app.dao.FemaleRepository;
import my.suveng.app.model.Female;
import my.suveng.app.model.FemaleVo;
import my.suveng.app.model.result.CodeEnum;
import my.suveng.app.model.result.Result;
import my.suveng.app.model.result.ResultBuilder;
import my.suveng.app.service.AppService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.sql.Struct;

/**
 * description:
 * @author suwenguang
 * @date 2019-09-01
 * @version 1.0.0
 **/
@Service
public class AppServiceImpl implements AppService {
	@Autowired
	private FemaleRepository femaleRepository;

	@Override
	public Result save(Female vo) {
		if (ObjectUtil.isEmpty(vo)) {
			return ResultBuilder.build(CodeEnum.CLIENT_EXCEPTION, vo);
		}
		Female save = femaleRepository.save(vo);
		return ResultBuilder.build(CodeEnum.SUCCESS, save);
	}

	@Override
	public Result delete(String id) {
		if (StrUtil.isBlank(id)) {
			return ResultBuilder.build(CodeEnum.CLIENT_EXCEPTION, "");
		}
		femaleRepository.deleteById(id);
		return ResultBuilder.build(CodeEnum.SUCCESS, "");
	}

	@Override
	public Result list(FemaleVo vo) {
		if (ObjectUtil.isEmpty(vo)) {
			return ResultBuilder.build(CodeEnum.CLIENT_EXCEPTION, "");
		}
		if (ObjectUtil.isEmpty(vo.getPage())) {
			vo.setPage(1);
		}
		if (ObjectUtil.isEmpty(vo.getSize())) {
			vo.setSize(10);
		}

		//分页
		PageRequest pageRequest = PageRequest.of(vo.getPage() - 1, vo.getSize());

		//多条件- 精准查询,模糊查询,范围查询
		Page<Female> res = null;

		//时间范围
		if (ObjectUtil.isNotEmpty(vo.getStart()) && ObjectUtil.isNotEmpty(vo.getEnd())) {
			//both
			return ResultBuilder.build(CodeEnum.SUCCESS,femaleRepository.findAllByCreateTimeBetween(vo.getStart(),vo.getEnd(),pageRequest).getContent());
		} else if (ObjectUtil.isNotEmpty(vo.getStart()) && ObjectUtil.isEmpty(vo.getEnd())) {
			//before
			return ResultBuilder.build(CodeEnum.SUCCESS,femaleRepository.findAllByCreateTimeBefore(vo.getStart(),pageRequest).getContent());

		} else if (ObjectUtil.isEmpty(vo.getStart()) && ObjectUtil.isNotEmpty(vo.getEnd())) {
			//after
			return ResultBuilder.build(CodeEnum.SUCCESS,femaleRepository.findAllByCreateTimeAfter(vo.getEnd(),pageRequest).getContent());
		} else {
			//none
			return ResultBuilder.build(CodeEnum.SUCCESS,femaleRepository.findAll(pageRequest).getContent());
		}
	}
}
