public enum EspecialidadeMedica {
    CARDIOLOGIA("Cardiologia"),
    DERMATOLOGIA("Dermatologia"),
    PEDIATRIA("Pediatria"),
    CLINICA_GERAL("Clínica Geral"),
    GINECOLOGIA_OBSTETRICIA("Ginecologia e Obstetrícia"),
    ORTOPEDIA("Ortopedia"),
    OFTALMOLOGIA("Oftalmologia"),
    GASTROENTEROLOGIA("Gastroenterologia"),
    ENDOCRINOLOGIA("Endocrinologia"),
    PSIQUIATRIA("Psiquiatria"),
    NEUROLOGIA("Neurologia"),
    OTORRINOLARINGOLOGIA("Otorrinolaringologia"),
    UROLOGIA("Urologia"),
    ANESTESIOLOGIA("Anestesiologia"),
    ONCOLOGIA("Oncologia");

    private final String descricao;

    EspecialidadeMedica(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EspecialidadeMedica fromDescricao(String nome) {
        for (EspecialidadeMedica especialidade : EspecialidadeMedica.values()) {
            if (especialidade.descricao.equalsIgnoreCase(nome.trim())) {
                return especialidade;
            }
        }
        return null;
    }
}