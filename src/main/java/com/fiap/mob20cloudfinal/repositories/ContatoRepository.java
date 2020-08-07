package com.fiap.mob20cloudfinal.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.fiap.mob20cloudfinal.domain.Contato;

@Repository
public class ContatoRepository {

	@Autowired
	private DynamoDBMapper mapper;

	public List<Contato> findAll() {
		return (List<Contato>) mapper.scan(Contato.class, new DynamoDBScanExpression());
	}

	public Contato add(Contato contato) {
		mapper.save(contato);
		return contato;
	}

	public Contato findById(String id) {
		return mapper.load(Contato.class, id);
	}

	public String delete(Contato contato) {
		mapper.delete(contato);
		return "Contato removido";
	}

	public String deleteById(String id) {
		Contato contato = mapper.load(Contato.class, id);
		if (contato != null) {
			return delete(contato);
		}
		else
			return "-1";
	}

	public String edit(Contato contato) {
		mapper.save(contato, buildExpression(contato));
		return "Contato atualizado";
	}

	private DynamoDBSaveExpression buildExpression(Contato contato) {
		DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
		expectedMap.put("id", new ExpectedAttributeValue(new AttributeValue().withS(contato.getId())));
		dynamoDBSaveExpression.setExpected(expectedMap);
		return dynamoDBSaveExpression;
	}
}
