package com.example.monopolia.gameplay

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.monopolia.R

class GameFieldManager(private val context: Context, private val containerView: ViewGroup) {

    private val cellsList: List<Cell> = createCellList()

    private fun createCellList(): List<Cell> {
        return listOf(
            Cell("startfield", R.drawable.startfield, ""),
            Cell("adidas", R.drawable.adidas, "$100"),
            Cell("tax1", R.drawable.tax1, ""),
            Cell("nike", R.drawable.nike, "200"),
            Cell("question1", R.drawable.question1, ""),
            Cell("audi", R.drawable.audi, "1000"),
            Cell("vk", R.drawable.vk, "400"),
            Cell("telegram", R.drawable.telegram, "500"),
            Cell("whatsApp", R.drawable.whatsapp, "600"),
            Cell("bus", R.drawable.bus, ""),
            Cell("pepsi", R.drawable.pepsi, "700"),
            Cell("mercedes", R.drawable.mercedes, "1000"),
            Cell("nestle", R.drawable.nestle, "800"),
            Cell("jail", R.drawable.jail, ""),
            Cell("steam", R.drawable.steam, "900"),
            Cell("tax2", R.drawable.tax2, ""),
            Cell("epicgames", R.drawable.epicgames, "1000"),
            Cell("gogcom", R.drawable.gogcom, "1100"),
            Cell("ford", R.drawable.ford, "1000"),
            Cell("alfabank", R.drawable.alfabank, "1200"),
            Cell("sber", R.drawable.sber, "1300"),
            Cell("question2", R.drawable.question2, ""),
            Cell("vtb", R.drawable.vtb, "1400"),
            Cell("handcuffs", R.drawable.handcuffs, "handcuffs"),
            Cell("nokia", R.drawable.nokia, "1500"),
            Cell("subaru", R.drawable.subaru, "1000"),
            Cell("apple", R.drawable.apple, "1600")
        )
    }

    fun populateField() {
        val topRowContainer = containerView.findViewById<LinearLayout>(R.id.topRowContainer)
        val topRowCells = cellsList.subList(0, 10)
        addCellsToContainer(topRowContainer, topRowCells,  1)

        val leftColumnContainer = containerView.findViewById<LinearLayout>(R.id.leftColumnContainer)
        val leftColumnCells = cellsList.subList(10, 13)
        addCellsToContainer(leftColumnContainer, leftColumnCells, 2)

        val rightColumnContainer =
            containerView.findViewById<LinearLayout>(R.id.rightColumnContainer)
        val rightColumnCells = cellsList.subList(13, 16)
        addCellsToContainer(rightColumnContainer, rightColumnCells, 4)

        val bottomRowContainer =
            containerView.findViewById<LinearLayout>(R.id.bottomRowContainer)
        val bottomRowCells = cellsList.subList(16, cellsList.size)
        addCellsToContainer(bottomRowContainer, bottomRowCells,  3)
    }

    private fun addCellsToContainer(
        container: ViewGroup,
        cellList: List<Cell>,
        direction: Int,
    ) {
        cellList.forEachIndexed { index, cell ->
            val cellView = CellView(context)
            cellView.setCellImage(cell.imageResId)
            cellView.setCellText(cell.price)
            cellView.setDirection(direction)
            val uniqueId = View.generateViewId()
            cellView.getView().id = uniqueId

            val layoutParams: LinearLayout.LayoutParams =
                if ((direction == 1 || direction == 3) && (index == 0 || index == cellList.lastIndex)) {
                    LinearLayout.LayoutParams(
                        context.resources.getDimension(R.dimen.vertical_column_width).toInt(),
                        context.resources.getDimension(R.dimen.horizontal_strip_height).toInt(),
                    )
                } else if ((direction == 1 || direction == 3)) {
                    LinearLayout.LayoutParams(
                            0,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    ).apply {
                        weight = 1f
                    }
                } else {
                    LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        0,
                    ).apply {
                        weight = 1f
                    }
                }
            container.addView(cellView.getView(), layoutParams)
        }
    }
}