package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.AlunoDao;
import model.dao.CidadeDao;
import model.dao.DaoAcademia;
import model.dao.EstadoDao;
import model.entities.Aluno;
import model.entities.Cidade;
import model.entities.Estado;

public class ProgramOficial {

	public static void main(String[] args) throws ParseException {
		
		CidadeDao cidadeDao = DaoAcademia.createCidadeDao();
		AlunoDao alunoDao = DaoAcademia.createAlunoDao();
		EstadoDao estadoDao = DaoAcademia.createEstadoDao();
		int opcao = 0;
		
		Scanner sc = new Scanner(System.in);
		do {
		System.out.println("----------- MENU INICIAL -----------");
		System.out.println("1 - Aluno");
		System.out.println("2 - Instrutor");
		System.out.println("3 - Plano");
		System.out.println("4 - Cidade");
		System.out.println("5 - Estado");
		System.out.println("6 - Horario");
		System.out.println("7 - Agendamento");
		System.out.println("8 - PlanoContratado");
		System.out.println("9 - Relatórios");
		System.out.println("Digite qual opção deseja acessar: ");
		
		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			System.out.println("----------- ALUNO -----------");
			System.out.println("1 - adicionar");
			System.out.println("2 - editar");
			System.out.println("3 - deletar");
			
			int opcao2 = sc.nextInt();
			
			switch (opcao2) {
			
			case 1:
				
				System.out.println("----------- ADICIONAR ALUNO -----------");
				sc.nextLine();
				System.out.println("Nome:");
				String nome = sc.nextLine();
				System.out.print("CPF:");
				String cpf = sc.nextLine();
				System.out.print("Telefone:");
				String telefone = sc.nextLine();
				System.out.print("Email:");
				String email = sc.nextLine();
				System.out.print("Sexo:");
				String sexo = sc.nextLine();
				System.out.print("Data Nascimento:");
				String dataRecebida = sc.nextLine();
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				Date dt = df.parse(dataRecebida);
				System.out.print("Rua:");
				String rua = sc.nextLine();
				System.out.print("Bairro:");
				String bairro = sc.nextLine();
				System.out.print("CEP:");
				Integer cep = sc.nextInt();
				System.out.print("Cod Cidade:");
				Integer codCidade = sc.nextInt();
				
				Cidade cidade = cidadeDao.findById(codCidade);
				
				Aluno aluno = new Aluno(null, nome, cpf, telefone, email, sexo, dt, rua, bairro, cep, cidade);
				alunoDao.insert(aluno);
				System.out.println("Aluno cadastrado! \n" + aluno );
				break;
				
			case 2:
				
				System.out.println("----------- EDITAR ALUNO -----------");
				System.out.print("Id do Aluno que deseja editar: ");
				Integer idAluno = sc.nextInt();
				aluno = alunoDao.findById(idAluno);
				System.out.print("Digite o novo nome do Aluno: ");
				aluno.setNome(sc.nextLine());
				alunoDao.update(aluno);
				System.out.println("Alterado com sucesso!");
				System.out.println("Novo nome: " + aluno.getNome());
				
				break;
			
			case 3:
				
				System.out.println("----------- DELETAR ALUNO -----------");
				System.out.print("Id do Aluno que deseja deletar: ");
				idAluno = sc.nextInt();
				aluno = alunoDao.findById(idAluno);
				alunoDao.deleteById(idAluno);
				System.out.println("Deletado com sucesso!");
				
			default:
				break;
			}
			break;
		case 9:
			System.out.println("----------- RELATÓRIO -----------");
			System.out.println("Id do estado que deseja ver todos os Alunos: ");
			sc.nextLine();
			String idEstado = sc.nextLine();
			System.out.println(idEstado);
			Estado estado = estadoDao.findById(idEstado);
			System.out.println(estado);
			
			List<Aluno> listAluno = alunoDao.findAlunoCidade(estado);
			for (Aluno obj : listAluno) {
				System.out.println(obj);
			}
				
				
			
			break;
		default:
			break;
		}

	}while (opcao != 0);
		
		sc.close();
}
}



