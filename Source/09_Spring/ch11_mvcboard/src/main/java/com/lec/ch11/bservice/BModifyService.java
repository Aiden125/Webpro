package com.lec.ch11.bservice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;
import com.lec.ch11.dto.BoardDto;

public class BModifyService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request"); 
		BoardDto bDto = (BoardDto)map.get("boardDto");
		bDto.setBip(request.getRemoteAddr());
		BoardDao boardDao = BoardDao.getInstance();
		model.addAttribute("modifyResult", boardDao.modify(bDto)); // 성공실패여부 장착
	}
}
