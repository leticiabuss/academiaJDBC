package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoAcademia;
import model.dao.EstadoDao;
import model.dao.InstrutorDao;
import model.dao.PlanoDao;
import model.entities.Instrutor;
import model.entities.Plano;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		EstadoDao estadoDao = DaoAcademia.createEstadoDao();
		InstrutorDao instrutorDao = DaoAcademia.createInstrutorDao();
		PlanoDao planoDao = DaoAcademia.createPlanoDao();

		System.out.println("\n -----TEST 1: Estado insert -----");
//		Estado estado = new Estado("JB", "João Bonito");
//		estadoDao.insert(estado);
//		System.out.println("Inserted! New estado = " + estado.getNome());
		
		System.out.println("\n -----TEST 2: Instrutor insert -----");
//		Instrutor instrutor = new Instrutor(null, "Pedro Souza", "30257994041", "47992567890", "pedro.souza@gmail.com", "M", new Date(1999, 8, 20) );
//		instrutorDao.insert(instrutor);
//		System.out.println("Inserted! New Instrutor = " + instrutor.getCodInstrutor());
		
		System.out.println("\n -----TEST 3: Plano insert -----");
//		Plano plano = new Plano(null, 59.90f, "Semestral" );
//		planoDao.insert(plano);
//		System.out.println("Inserted! New Instrutor = " + plano.getCod());
		
		System.out.println("\n -----TEST 3: Instrutor findById -----");
		Instrutor instrutor = instrutorDao.findById(1);
		System.out.println(instrutor);
		
		System.out.println("\n -----TEST 3: Plano update -----");
		Plano plano = planoDao.findById(3);
		plano.setValor(49.90f);
		planoDao.update(plano);
		System.out.println(plano);
		
		System.out.println("\n -----TEST 3: Instrutor findAll -----");
		List<Instrutor> list = instrutorDao.findAll();
		for (Instrutor listInstrutor : list) {
			System.out.println(listInstrutor);
		}
//		
		System.out.println("\n -----TEST 3: Instrutor insert -----");
		System.out.println("Enter id for delete test:");
		int id = sc.nextInt();
		planoDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
		
	}

}
