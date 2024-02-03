package com.lavrent.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lavrent.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { // Создаю экран полностью основанный на Compose, нужно поросить activity вызвать метод setContent() и предать в нее составные функции
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface( // контейнер обозначает форму
                    modifier = Modifier.fillMaxSize(), // модификатором позволяющему, компоноваемому контейнеру заполнить максимальную ширину, заданную ему родительским элементом.
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Jetpack Compose")
                }
            }
        }
    }
}

@Composable // Аннтоация Compose обозначающая составную функцию
fun Greeting(name: String, modifier: Modifier = Modifier) { // Составная функция, описываем UI, пишем всегда с заглавной буквы

    Column(modifier.fillMaxSize()) { // Использую столбец , с модификатором позволяющему, компоноваемому элементу заполнить максимальную ширину, заданную ему родительским элементом.
        Image( // Элемент(компонент) изображение
            painter = painterResource(id = R.drawable.bg_compose_background), // Использую ресурс drawable
            contentDescription = null // Представляет строковое описание для изображения, которое применяется сервисами accessibility в служебных целях, без нее будет ошибка!!!
        )
        Text( // Элемент(компонент) текс 1
            text = "$name tutorial", // Содержимое текса
            modifier = modifier.padding( // Модификатор отступов компонента text 2, описал одинаковые отступы со всех сторон на глядно(расширенно)
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
            fontSize = 24.sp // Тут размер шрифта 24, sp  рекоменуется использовать для шрифта, потому тчо это маштабируеммые пиксели, не будут зависеть от пиксельности плотности экрана устройства
        )
        Text( // Элемент(компонент) текс 2
            text = stringResource(R.string.jetpack_compose_is_a_modern_toolkit), // Содержимое текса, хранимое в ресурсах string
            modifier = modifier.padding( // Модификатор отступов компонента text 2 , описал как по заданию в начале компонента и в конце
                start = 16.dp,
                end = 16.dp
            ),
            textAlign = TextAlign.Justify, // Растягиваю строки текста, которые заканчиваются мягким переносом строки, чтобы заполнить ширину контейнера
            fontSize = TextUnit.Unspecified // Так карсиво обозначается размер шрифта по умолчанию, но как я понял можно это вообще не обозначать
        )
        Text( // Элемент(компонент) текс 3
            text = stringResource(R.string.in_this_tutorial_you_build), // Содержимое текса, хранимое в ресурсах string
            textAlign = TextAlign.Justify, // Растягиваю строки текста, которые заканчиваются мягким переносом строки, чтобы заполнить ширину контейнера
            fontSize = TextUnit.Unspecified, // Так карсиво обозначается размер шрифта по умолчанию, но как я понял можно это вообще не обозначать
            modifier = modifier.padding(16.dp) // модификатор отступов компонента text 2, тут отступ со всех сторон
        )
    }
}

@Preview(showBackground = true) // В скобочках после превью аннтоации, это добаляется фон, потому что по умолчанию фон прозрачный
@Composable // Это составная функция Compose, c аннтоацией @Preview, Для просмотра рендера UI во вкладке Design
fun GreetingPreview() {
    LearnTogetherTheme {
        Greeting("Jetpack Compose") // Тут в теле находится составная вызываемая функция
    }
}