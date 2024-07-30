package code.yousef.blog.pages.admin

import androidx.compose.runtime.*
import code.yousef.blog.LoginButtonStyle
import code.yousef.blog.LoginInputStyle
import code.yousef.blog.toSitePalette
import code.yousef.blog.utils.Constants.FONT_FAMILY
import code.yousef.blog.utils.Res
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.forms.Input
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button

@Page
@Composable
fun LoginScreen() {
    val sitePalette = ColorMode.current.toSitePalette()
    var errorText by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(leftRight = 50.px, top = 80.px, bottom = 24.px)
                .backgroundColor(sitePalette.nearBackground),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(100.px)
                    .margin(50.px),
                src = Res.Image.logo,
                description = "Logo Image"
            )
            Input(
                type = InputType.Text,
                modifier = LoginInputStyle.toModifier()
                    .width(350.px)
                    .height(54.px)
                    .padding(leftRight = 20.px)
                    .margin(bottom = 12.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(14.px)
                    .backgroundColor(sitePalette.backgroundColor),
                onValueChange = {},
                value = "",
                placeholder = "Username"
            )
            Input(
                type = InputType.Password,
                modifier = LoginInputStyle.toModifier()
                    .width(350.px)
                    .height(54.px)
                    .padding(leftRight = 20.px)
                    .margin(bottom = 20.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(14.px)
                    .backgroundColor(sitePalette.backgroundColor),
                onValueChange = {},
                value = "",
                placeholder = "Password"
            )
            Button(
                attrs = LoginButtonStyle.toModifier()
                    .width(350.px)
                    .height(54.px)
                    .color(Colors.White)
                    .border(
                        width = 0.px,
                        style = LineStyle.None,
                        color = Colors.Transparent
                    )
                    .outline(
                        width = 0.px,
                        style = LineStyle.None,
                        color = Colors.Transparent
                    )
                    .cursor(Cursor.Grab)
                    .borderRadius(r = 4.px)
                    .fontWeight(FontWeight.Medium)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(14.px)
                    .margin(bottom = 24.px)
                    .toAttrs(),
            ) {
                SpanText(text = "Sign In")
            }
            SpanText(
                modifier = Modifier
                    .width(350.px)
                    .color(Colors.Red)
                    .textAlign(TextAlign.Center),
                text = errorText
            )
        }
    }
}