package com.medise.nahalit.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.medise.nahalit.presentation.home_screen.components.MenuItem

object MenuItems {
    val list: List<MenuItem>
        get() {
            return listOf(
                MenuItem(
                    id = 0,
                    title = "ورود/عضویت",
                    icon = Icons.Default.Person
                ),
                MenuItem(
                    1,
                    title = "خانه",
                    icon = Icons.Default.Home
                ),
                MenuItem(
                    id = 2,
                    title = "محصولات",
                    icon = Icons.Default.ShoppingCart
                ),
                MenuItem(
                    id = 3,
                    title = "زیر مجموعه محصولات",
                    icon = Icons.Default.FavoriteBorder
                ),
                MenuItem(
                    id = 4,
                    title = "قالب ورد پرسی",
                    icon = Icons.Default.MoreVert
                ),
                MenuItem(
                    id = 5,
                    title = "زاهنمای خرید",
                    icon = Icons.Default.ShoppingCart
                ),
                MenuItem(
                    id = 6,
                    title = "بلاگ",
                    icon = Icons.Default.Build
                ),
                MenuItem(
                    id = 7,
                    title = "نمونه کار",
                    icon = Icons.Default.Edit
                ),
                MenuItem(
                    id = 8,
                    title = "زیر مجموعه های نمونه کارو گرافیک",
                    icon = Icons.Default.Edit
                ),
                MenuItem(
                    id = 9,
                    title = "تیم نهال",
                    icon = Icons.Default.Create
                ),
                MenuItem(
                    id = 10,
                    title = "استخدام",
                    icon = Icons.Default.Person
                )
            )
        }
}