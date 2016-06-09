package tools;

public class ParsingString {

	public String parsedStringToBeSearched(String _chaine_a_parser) {

		String chaine_parsee;

		chaine_parsee = _chaine_a_parser;
		String[] splited = chaine_parsee.split("\\s+");
		String chaine_rassemblee = "";

		for (int i = 0; i < (splited.length); i++)
			chaine_rassemblee = chaine_rassemblee + "%" + splited[i];

		chaine_parsee = "'" + chaine_rassemblee + "%'";

		return chaine_parsee;
	}
}
