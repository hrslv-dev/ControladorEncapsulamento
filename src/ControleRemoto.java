public class ControleRemoto implements Controlador{

    private int volume;
    private boolean ligado;
    private boolean tocando;

    public ControleRemoto(){
        this.volume = 50;
        this.ligado = false;
        this.tocando = false;
    }
    // METODO GETTERS

    private int getVolume(){return this.volume;}
    private boolean getLigado(){return this.ligado;}
    private boolean getTocando(){return this.tocando;}

    // METODOS SETTERS

    private void setVolume(int vol){this.volume = vol;}
    private void setLigado(boolean onOff){this.ligado = onOff;}
    private void setTocando(boolean toc){this.tocando = toc;}

    // METODOS DE INTERFACE

    @Override                       // Sempre é necessário reescrever um método de interface dentro do controlador
    public void ligar(){
        setLigado(true);
    };
    @Override
    public void desligar(){
        setLigado(false);
    }
    @Override
    public void abrirMenu(){
        System.out.println("Menu abrindo..");
        System.out.println("ON / OFF - > " + this.getLigado());
        System.out.println("TOCANDO :" + this.getTocando());
        System.out.println("VOLUME: " + this.getVolume());

        for(int i = 0; i<= this.getVolume(); i +=10){
            System.out.println("[]");
        }
    }
    @Override
    public void fecharMenu(){
        System.out.println("Menu fechando..");
    }
    @Override
    public void maisVolume(){
       if(this.getLigado()){
            this.setVolume(this.getVolume() +5);
       }
    }
    @Override
    public void menosVolume(){
        if(this.getLigado()){
            this.setVolume(this.getVolume() -5);
        }
    }
    @Override
    public void ligarMudo(){
        if(this.getLigado() && this.getVolume() > 0){
            this.setVolume(0);
        }
    }
    @Override
    public void desligarMudo(){
        if(this.getLigado() && this.getVolume() == 0){
            this.setVolume(50);
        }
    }
    @Override
    public void play(){
        if(this.getLigado()){
            this.setTocando(true);
        }
    }
    @Override
    public void pause(){
       if(this.getLigado()){
           this.setTocando(false);
       }
    }
}
