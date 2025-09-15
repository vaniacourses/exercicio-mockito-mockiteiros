import jogo.Jogo;
import jogo.Dado;
import jogo.Jogador;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class JogoTest {

    @Test
    void deveGanharCom7Turno1() {
        Jogador jogador = mock(Jogador.class);
        Dado d1 = mock(Dado.class);
        Dado d2 = mock(Dado.class);

        when(jogador.lancar(d1, d2)).thenReturn(7);

        Jogo jogo = new Jogo(jogador, d1, d2);
        assertTrue(jogo.jogar());
    }

    @Test
    void devePerderCom2NoTurno1() {
        Jogador jogador = mock(Jogador.class);
        Dado d1 = mock(Dado.class);
        Dado d2 = mock(Dado.class);

        when(jogador.lancar(d1, d2)).thenReturn(2);

        Jogo jogo = new Jogo(jogador, d1, d2);
        assertFalse(jogo.jogar());
    }

    @Test
    void deveGanharNoTerceiroLançamento() {
        Jogador jogador = mock(Jogador.class);
        Dado d1 = mock(Dado.class);
        Dado d2 = mock(Dado.class);

        when(jogador.lancar(d1, d2)).thenReturn(8, 5, 8);

        Jogo jogo = new Jogo(jogador, d1, d2);
        assertTrue(jogo.jogar());
    }

    @Test
    void devePerderNoSegundoTurnoTirando7() {
        Jogador jogador = mock(Jogador.class);
        Dado d1 = mock(Dado.class);
        Dado d2 = mock(Dado.class);

        when(jogador.lancar(d1, d2)).thenReturn(6, 7);

        Jogo jogo = new Jogo(jogador, d1, d2);
        assertFalse(jogo.jogar());
    }
}
