# JAVA e JPA

## Pesquise com JPQL e Criteria

### Tópicos:
1.  **Relacionamentos bidirecionais** \
  1.1   Como mapear relacionamentos bidirecionais \
  1.2   Que relacionamentos bidirecionais precisam ser "unidos" pelo atributo `mappedBy` \
  1.3   O lado inverso do relacionamento é opcional \
  1.4   Para o schema no banco vale o lado "forte" do relacionamento (que não usa `mappedBy`) 

2.  **Lidando com queries N+1** \
  2.1   Relacionamento `*ToMany` são *Lazy* por padrão \
  2.2   *Lazy* significa que só serão carregados sob demanda \
  2.3   Podemos reconfigurar esse comportamento pele atributo `fetch` da anotação usando a enum `FetchType.EAGER` \
  2.4   Nas queries podemos inicializar um relacionamento lazy usando `join fetch`
    * para receber apenas resultados distintos podemos usar a palavra chave `distinct`

3. **Funções de agregação e Gourp By** \
  3.1   JPQL também possui a cláusula `group` by que pode ser usado em combinação com as funções de agregação \
  3.2   Como executar projeções e "instanciar objetos" já pelo JPQL \
  3.3   JPQL possui os tipico funções de agregação do mundo SQL 
    * Exemplos são `SUM`, `AVG`, `MIN`, `MAX` ou `COUNT` 

4. **Camada de Persistência** \
  4.1   Mesmo com JPA faz sentido usar um DAO para encapsular as queries \
  4.2   Em algumas bibliotecas chamam os DAO de repositórios (por exemplo Spring Data) \
  4.3   O DAO deve receber o `EntityManager` como dependência (preferencialmente pelo construtor) \
  4.4   `NamedQuery` é uma forma de associar a entidade com suas queries 
    * `NamedQuery` tem uma vantagem pois é analisada ao criar o `EntityManager`

5. **Queries dinâmicas com Criteria** \
  5.1   A JPQL deve ser usada para queries fixas que sempre buscam pelos mesmo parâmetros \
  5.2   Quando a query é dinâmica o JPQL perde a legibilidade e o código fica mais difícil de se manter \
  5.3   Para solucionar isso foi criado uma outra API de pesquisa, a **Criteria API**. \
  5.4   A criteria permite definir queries apenas com chamadas de métodos e assim possui mais flexibilidade quando os parâmetros variam \
  5.5   Os protagonistas da criteria são:
    * `CriteriaQuery` - a query em si, que possui os métodos principais como `select(..)`, `from(..)` e `where(..)`
    * `Criteriabuilder` - uma classe auxiliar para definir filtros e projeções
    * `Root`- para definir os caminhas para atributos *(m.data)*

