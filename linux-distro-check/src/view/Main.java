package view;

import controller.DistroController;

public class Main {

	public static void main(String[] args) {
		DistroController dc = new DistroController();
		
		dc.exibeDistro("cat /etc/os-release");
	}

}
