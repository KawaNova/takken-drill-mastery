package com.kawanova.takkendrill.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class TakkenDrillDataTest {

    @Test
    fun testTotalQuestionsCount() {
        val questions = TakkenQuestionsData.questions
        assertEquals("Total questions must be exactly 30", 30, questions.size)
    }

    @Test
    fun testCategoryDistribution() {
        val questions = TakkenQuestionsData.questions

        val rights = questions.filter { it.category == TakkenCategory.RIGHTS }
        val businessLaw = questions.filter { it.category == TakkenCategory.BUSINESS_LAW }
        val restrictions = questions.filter { it.category == TakkenCategory.RESTRICTIONS }
        val taxOthers = questions.filter { it.category == TakkenCategory.TAX_OTHERS }

        assertEquals("Rights questions count", 8, rights.size)
        assertEquals("Business Law questions count", 12, businessLaw.size)
        assertEquals("Restrictions questions count", 6, restrictions.size)
        assertEquals("Tax & Others questions count", 4, taxOthers.size)
    }

    @Test
    fun testQuestionIntegrity() {
        val questions = TakkenQuestionsData.questions

        questions.forEach { q ->
            assertTrue("ID must be positive: ${q.id}", q.id > 0)
            assertTrue("Title Ja must not be blank in Q${q.id}", q.titleJa.isNotBlank())
            assertTrue("Title En must not be blank in Q${q.id}", q.titleEn.isNotBlank())
            assertTrue("Question Ja must not be blank in Q${q.id}", q.questionJa.isNotBlank())
            assertTrue("Question En must not be blank in Q${q.id}", q.questionEn.isNotBlank())

            assertEquals("Options Ja must have exactly 4 choices in Q${q.id}", 4, q.optionsJa.size)
            assertEquals("Options En must have exactly 4 choices in Q${q.id}", 4, q.optionsEn.size)

            assertTrue("CorrectAnswerIndex must be in 0..3 in Q${q.id}", q.correctAnswerIndex in 0..3)

            assertTrue("Explanation Ja must not be blank in Q${q.id}", q.explanationJa.isNotBlank())
            assertTrue("Explanation En must not be blank in Q${q.id}", q.explanationEn.isNotBlank())
            assertTrue("ExamTip Ja must not be blank in Q${q.id}", q.examTipJa.isNotBlank())
            assertTrue("ExamTip En must not be blank in Q${q.id}", q.examTipEn.isNotBlank())
        }
    }

    @Test
    fun testCheatDataIntegrity() {
        val cheatItems = TakkenCheatData.cheatItems
        assertEquals("Cheat items must be exactly 24", 24, cheatItems.size)

        cheatItems.forEach { item ->
            assertTrue("Cheat topic Ja must not be blank in #${item.id}", item.topicJa.isNotBlank())
            assertTrue("Cheat topic En must not be blank in #${item.id}", item.topicEn.isNotBlank())
            assertTrue("Key points Ja must not be empty in #${item.id}", item.keyPointsJa.isNotEmpty())
            assertTrue("Key points En must not be empty in #${item.id}", item.keyPointsEn.isNotEmpty())
            assertTrue("Copyable text must not be blank in #${item.id}", item.copyableText.isNotBlank())
        }
    }

    @Test
    fun testVisualizerScenarios() {
        val scenarios = VisualizerScenario.entries
        assertEquals("Must have 3 key interactive scenarios", 3, scenarios.size)
        scenarios.forEach {
            assertNotNull(it.titleJa)
            assertNotNull(it.titleEn)
            assertNotNull(it.descriptionJa)
            assertNotNull(it.descriptionEn)
        }
    }
}
