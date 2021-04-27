package br.com.propostaot3.Proposta.proposta;

public enum Status { ELEGIVEL, NAO_ELEGIVEL, NAO_AVALIADO;

    public static Status definirStatusPorRestricao(String comOuSemRestricao){
        if(comOuSemRestricao.equalsIgnoreCase("SEM_RESTRICAO")) return ELEGIVEL;
        return NAO_ELEGIVEL;
    }
}
