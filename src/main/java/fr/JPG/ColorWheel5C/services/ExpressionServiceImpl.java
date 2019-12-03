package fr.JPG.ColorWheel5C.services;

import fr.JPG.ColorWheel5C.models.Expression;

public class ExpressionServiceImpl implements ExpressionService {

    private Expression expressionRepo;

    @Override
    public Expression getExpression(String code) {
        return expressionRepo;
    }
}
