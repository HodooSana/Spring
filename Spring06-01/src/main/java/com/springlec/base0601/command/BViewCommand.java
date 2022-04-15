package com.springlec.base0601.command;

import org.springframework.ui.Model;

import com.springlec.base0601.dao.BDao;

public class BViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		BDao dao = new BDao();
		
		
	}

}
