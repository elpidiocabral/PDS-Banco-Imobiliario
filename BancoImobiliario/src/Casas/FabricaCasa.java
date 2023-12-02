package Casas;

public class FabricaCasa implements IFabricaCasa {
    
    public ICasa criarCasa(String tipo, String nome, int grupo) {
       switch (tipo) {
        case "Efeito":
            return new CasaEfeito(nome, grupo);  
        case "SR":
            return new CasaSR(nome, grupo);        
        default:
            return new CasaCarta(nome, grupo);
       }
    }
}
